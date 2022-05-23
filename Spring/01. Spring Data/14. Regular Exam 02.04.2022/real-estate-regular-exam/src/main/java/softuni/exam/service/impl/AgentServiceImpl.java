package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentSeedDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class AgentServiceImpl implements AgentService {

    private static final String AGENTS_FILE_PATH = "src/main/resources/files/json/agents.json";

    private final TownService townService;
    private final AgentRepository agentRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public AgentServiceImpl(TownService townService, AgentRepository agentRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.townService = townService;
        this.agentRepository = agentRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_FILE_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readAgentsFromFile(), AgentSeedDto[].class))
                .filter(agentSeedDto -> {
                    boolean isValid = validationUtil.isValid(agentSeedDto) &&
                            !agentRepository.existsByFirstName(agentSeedDto.getFirstName());

                    stringBuilder
                            .append(isValid
                                    ? String.format("Successfully imported agent - %s %s", agentSeedDto.getFirstName(), agentSeedDto.getLastName())
                                    : "Invalid agent")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(agentSeedDto -> {
                    Agent agent = modelMapper.map(agentSeedDto, Agent.class);
                    agent.setTown(townService.findByName(agentSeedDto.getTown()));

                    return agent;
                })
                .forEach(agentRepository::save);

        return stringBuilder.toString();
    }
}
