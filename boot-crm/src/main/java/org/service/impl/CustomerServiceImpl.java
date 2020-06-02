package org.service.impl;

import org.apache.commons.lang.StringUtils;
import org.dao.CustomerMapper;
import org.po.Customer;
import org.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.utils.Page;

import java.util.List;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource, String custIndustry, String custLevel) {
        // 创建客户对象
        Customer customer = new Customer();
        // 判断客户名称
        if(StringUtils.isNotBlank(custName)){
            customer.setCustName(custName);
        }
        // 判断客户信息来源
        if(StringUtils.isNotBlank(custSource)){
            customer.setCustSource(custSource);
        }
        // 判断客户所属行业
        if(StringUtils.isNotBlank(custIndustry)){
            customer.setCustIndustry(custIndustry);
        }
        // 判断客户级别
        if(StringUtils.isNotBlank(custLevel)){
            customer.setCustLevel(custLevel);
        }
        // 当前页
        customer.setStart((page-1) * rows) ;
        // 每页数
        customer.setRows(rows);
        // 查询客户列表
        List<Customer> customers =
                customerMapper.selectCustomerList(customer);
        // 查询客户列表总记录数
        Integer count = customerMapper.selectCustomerListCount(customer);
        // 创建Page返回对象
        Page<Customer> result = new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    @Override
    public int createCustomer(Customer customer) {
        return customerMapper.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        Customer customer = customerMapper.getCustomerById(id);
        return customer;
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    @Override
    public int deleteCustomer(Integer id) {
        return customerMapper.deleteCustomer(id);
    }
}
