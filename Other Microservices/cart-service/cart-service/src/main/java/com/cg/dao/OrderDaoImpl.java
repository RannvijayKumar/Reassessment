package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.cg.model.Cart;

@Repository(value = "orderDao")
public class OrderDaoImpl implements OrderDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public List<Cart> viewcartByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		
//		String jpql = "userId.cartId,sum(productPrice*quantity) as total from cart c join user u on c.userId=u.userId where c.userId=:customerId";
//				
//		SELECT DISTINCT e FROM Employee e INNER JOIN e.tasks t where t.supervisor='Denise'
//			String jpql =	"select c,c.cartId,sum(c.quantity*c.productPrice) FROM Cart c INNER JOIN User u where c.userId=:customerId";
		String jpql = "from Cart where user_Id =: customerId";
			
		
		
		Query query = entityManager.createQuery(jpql);
		query.setParameter("customerId", customerId);
		
		List<Cart> ol = query.getResultList();
		
		return ol;
	}
	
	
	

}