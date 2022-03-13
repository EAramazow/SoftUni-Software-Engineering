package springdataintro.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "accounts")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NonNull
    private BigDecimal balance;

    @ManyToOne
    @ToString.Exclude
    private User user;

}
