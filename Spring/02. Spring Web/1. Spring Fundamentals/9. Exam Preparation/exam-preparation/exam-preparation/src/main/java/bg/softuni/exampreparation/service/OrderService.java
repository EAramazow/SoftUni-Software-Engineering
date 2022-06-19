package bg.softuni.exampreparation.service;

import bg.softuni.exampreparation.model.service.OrderServiceModel;
import bg.softuni.exampreparation.model.view.OrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(OrderServiceModel orderServiceModel);

    List<OrderViewModel> findAllOrdersOrderByPriceDesc();

    void readyOrder(Long id);
}
