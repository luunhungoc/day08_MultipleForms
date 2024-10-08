package mvc.repository;

import mvc.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity,Integer> {
    @Query(value="select * from Orders where month(orderDate) = month(current_date())",nativeQuery=true)
    List<OrderEntity> findOrderByCurrentMonth();

    @Query(value="select * from Orders where id= ?1",nativeQuery=true)
    List<OrderEntity> findByOrderId(int i);

    @Query(value="select * from orders join orderDetails where orderDetails.productName like ?1% and orders.id = orderDetails.orderId",nativeQuery=true)
    List<OrderEntity> findByProductNameContaining(String productName);

    @Query(value="SELECT * FROM Orders JOIN orderDetails GROUP BY orders.id HAVING SUM(orderDetails.quantity * orderDetails.unitPrice) > ?1",nativeQuery=true)
    List<OrderEntity> findOrderByTotalAmountGreaterThan(double price);

}
