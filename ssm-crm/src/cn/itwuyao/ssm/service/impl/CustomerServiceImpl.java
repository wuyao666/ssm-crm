package cn.itwuyao.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itwuyao.ssm.mapper.BaseDictMapper;
import cn.itwuyao.ssm.mapper.CustomerMapper;
import cn.itwuyao.ssm.pojo.BaseDict;
import cn.itwuyao.ssm.pojo.Customer;
import cn.itwuyao.ssm.pojo.QueryVo;
import cn.itwuyao.ssm.service.CustomerService;
import cn.itwuyao.ssm.utils.Page;

//@Transactional
@Service(value="customerService")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private BaseDictMapper baseDictMapper;
	@Autowired
	private CustomerMapper customerMapper;
	
	public List<BaseDict> findBaseDictByDictTypeCode(String dictTypeCode) {
		return baseDictMapper.findBaseDictByDictTypeCode(dictTypeCode);
	}

	public Page<Customer> queryCustomerByPage(QueryVo queryVo) {
		Page<Customer> page = new Page<Customer>();
		//设置当前页码数
		if(queryVo.getPage()!=null){
			page.setPage(queryVo.getPage());
		}
		//查询总页数
		Integer total=customerMapper.findTotal(queryVo);
		page.setTotal(total);
		//设置每页数据
		if(queryVo.getRows()!=null){
			page.setSize(queryVo.getRows());
		}else{
			page.setSize(5);
		}
		//设置每页开始索引
		queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
		List<Customer> clist=customerMapper.queryCustomerByPage(queryVo);
		//设置每页数据
		page.setRows(clist);
		return page;
	}


	/**
	 * 根据id删除数据
	 */
	public void delete(Integer id) {
		customerMapper.delete(id);
	}

	/**
	 * 根据id查询数据
	 */
	public Customer findCustomerById(Integer id) {
		
		return customerMapper.findCustomerById(id);
	}

	/**
	 * 根据id查询修改数据
	 */
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}

}
