package cn.itwuyao.ssm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itwuyao.ssm.pojo.BaseDict;
import cn.itwuyao.ssm.pojo.Customer;
import cn.itwuyao.ssm.pojo.QueryVo;
import cn.itwuyao.ssm.service.CustomerService;
import cn.itwuyao.ssm.utils.Page;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	//客户行业 为001
	@Value(value="${CUSTOMER_INDUSTRY_TYPE}")
	private String industryType;
	//客户来源为002
	@Value(value="${CUSTOMER_FROM_TYPE}")
	private String fromType;
	//客户级别 为006
	@Value(value="${CUSTOMER_LEVEL_TYPE}")
	private String levelType;
	
	@RequestMapping(value="/list.action")
	public String queryCustomerList(QueryVo queryVo,HttpServletRequest request){
		//去除客户名称查询中的空格
		if(queryVo.getCustName()!=null){
			queryVo.setCustName(queryVo.getCustName().trim());
		}
		//查询客户行业列表
		List<BaseDict> iList = customerService.findBaseDictByDictTypeCode(industryType);
		request.setAttribute("industryType", iList);
		//查询客户来源列表
		List<BaseDict> fList = customerService.findBaseDictByDictTypeCode(fromType);
		request.setAttribute("fromType", fList);
		//查询客户级别列表
		List<BaseDict> lList = customerService.findBaseDictByDictTypeCode(levelType);
		request.setAttribute("levelType", lList);
		//查询每页的数据
		Page<Customer> page=customerService.queryCustomerByPage(queryVo);
		request.setAttribute("page", page);
		
		return "customer";
	}
	
	@RequestMapping(value="/delete.action")
	@ResponseBody
	public String delete(Integer id){		
		customerService.delete(id);
		return "ok";
	}
	
	@RequestMapping(value="/edit.action")
	@ResponseBody
	public Customer edit(Integer id){		
		Customer customer = customerService.findCustomerById(id);
		return customer;
	}
	
	@RequestMapping(value="/update.action")
	@ResponseBody
	public String update(Customer customer){		
		customerService.updateCustomerById(customer);
		return "ok";
	}
	
}
