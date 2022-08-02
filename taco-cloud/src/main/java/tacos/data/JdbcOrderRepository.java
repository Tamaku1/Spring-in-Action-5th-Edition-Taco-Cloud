//package tacos.data;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
//import org.springframework.stereotype.Repository;
//import tacos.model.Order;
//import tacos.model.Taco;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Repository
//public class JdbcOrderRepository implements OrderRepository{
//
//    private SimpleJdbcInsert orderInserter;
//    private SimpleJdbcInsert orderTacoInserter;
//    private ObjectMapper objectMapper;
//
//    @Autowired
//    public JdbcOrderRepository(JdbcTemplate jdbcTemplate){
//        this.orderInserter = new SimpleJdbcInsert(jdbcTemplate)
//                .withTableName("Taco_Order")
//                .usingGeneratedKeyColumns("id");
//        this.orderTacoInserter = new SimpleJdbcInsert(jdbcTemplate)
//                .withTableName("Taco_Order_Tacos");
//        this.objectMapper = new ObjectMapper();
//    }
//
//
//
//    @Override
//    public Order save(Order order) {
//        order.setPlacedAt(new Date());
//        order.setId(saveOrderDetails(order));
//        order.getTacos().forEach(it -> saveTacoToOrder(it.getId(), order.getId()));
//        return order;
//    }
//
//    private long saveOrderDetails(Order order) {
//        @SuppressWarnings("unchecked")
//        Map<String, Object> values = objectMapper.convertValue(order, Map.class);
//        return orderInserter.executeAndReturnKey(values).longValue();
//    }
//
//    private void saveTacoToOrder(long tacoId, long orderId) {
//        Map<String, Object> values = new HashMap<>();
//        values.put("tacoOrder", orderId);
//        values.put("taco", tacoId);
//        orderTacoInserter.execute(values);
//    }
//}
