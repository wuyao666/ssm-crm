package cn.itwuyao.ssm.service;

import java.util.List;

import cn.itwuyao.ssm.pojo.BaseDict;
import cn.itwuyao.ssm.pojo.Customer;
import cn.itwuyao.ssm.pojo.QueryVo;
import cn.itwuyao.ssm.utils.Page;

public interface CustomerService {
	
	List<BaseDict> findBaseDictByDictTypeCode(String dictTypeCode);

	Page<Customer> queryCustomerByPage(QueryVo queryVo);

	void delete(Integer id);

	Customer findCustomerById(Integer id);

	void updateCustomerById(Customer customer);
	
	
}
