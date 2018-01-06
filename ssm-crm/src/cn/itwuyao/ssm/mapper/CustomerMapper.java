package cn.itwuyao.ssm.mapper;

import java.util.List;

import cn.itwuyao.ssm.pojo.Customer;
import cn.itwuyao.ssm.pojo.QueryVo;
import cn.itwuyao.ssm.utils.Page;

public interface CustomerMapper {

	/**
	 * 分页实现时查询总记录数
	 * @param queryVo
	 * @return
	 */
	Integer findTotal(QueryVo queryVo);
	
	/**
	 * 分页条件查询每页数据
	 * @param queryVo
	 * @return
	 */
	List<Customer> queryCustomerByPage(QueryVo queryVo);
	
	/**
	 * 根据id删除客户数据
	 * @param id
	 */
	void delete(Integer id);
	
	/**
	 * 根据id查询客户信息
	 * @param id
	 */
	Customer findCustomerById(Integer id);
	
	/**
	 * 根据id修改客户信息
	 * @param customer
	 */
	void updateCustomerById(Customer customer);
	


}
