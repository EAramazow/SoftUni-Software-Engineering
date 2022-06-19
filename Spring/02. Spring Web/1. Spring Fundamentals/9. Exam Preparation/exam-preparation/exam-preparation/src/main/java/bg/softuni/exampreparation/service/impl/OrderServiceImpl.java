package bg.softuni.exampreparation.service.impl;

import bg.softuni.exampreparation.model.entity.OrderEntity;
import bg.softuni.exampreparation.model.service.OrderServiceModel;
import bg.softuni.exampreparation.repository.OrderRepository;
import bg.softuni.exampreparation.service.CategoryService;
import bg.softuni.exampreparation.service.OrderService;
import bg.softuni.exampreparation.service.UserService;
import bg.softuni.exampreparation.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(OrderServiceModel orderServiceModel) {
        OrderEntity order = modelMapper.map(orderServiceModel, OrderEntity.class);

        // set current logged user
        order.setEmployee(userService.findById(currentUser.getId()));
        order.setCategory(categoryService.findByCategoryNameEnum(orderServiceModel.getCategory()));

        orderRepository.save(order);

    }
}
