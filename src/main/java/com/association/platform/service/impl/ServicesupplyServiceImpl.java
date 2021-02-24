package com.association.platform.service.impl;

import com.association.platform.entity.Moneyrequire;
import com.association.platform.entity.Servicesupply;
import com.association.platform.mapper.MoneyrequireMapper;
import com.association.platform.mapper.ServicesupplyMapper;
import com.association.platform.service.IServicesupplyService;
import com.association.platform.util.Result;
import com.association.platform.util.ResultCode;
import com.association.platform.util.ResultMsg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author luming
 * @since 2021-02-22
 */
@Service
public class ServicesupplyServiceImpl extends ServiceImpl<ServicesupplyMapper, Servicesupply> implements IServicesupplyService {
    @SuppressWarnings("All")
    @Autowired
    ServicesupplyMapper servicesupplyMapper;

    public Result add(Servicesupply servicesupply){
        if (Objects.isNull(servicesupply)){
            return new Result(ResultCode.FAIL.code, ResultMsg.ParameterMissing.msg);
        }
        servicesupplyMapper.insert(servicesupply);
        return new Result(ResultCode.SUCCESS.code,ResultMsg.ApplySuccess.msg);
    }

    public Result delete(Servicesupply servicesupply){
        if (servicesupply.getId().isEmpty()){
            return new Result(ResultCode.FAIL.code,ResultMsg.ParameterMissing.msg);
        }
        servicesupplyMapper.deleteById(servicesupply.getId());
        return new Result(ResultCode.SUCCESS.code,ResultMsg.DeleteSuccess.msg,servicesupply);
    }

    public Result showAll(){
        List<Servicesupply> servicesupplies = servicesupplyMapper.selectList(null);
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,servicesupplies);
    }

    public Result searchBySupplytype(String key){
        List<Servicesupply> lists = servicesupplyMapper.selectList(new QueryWrapper<Servicesupply>().like("supplytype", key));
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,lists);
    }

    public Result searchByCity(String key){
        List<Servicesupply> lists = servicesupplyMapper.selectList(new QueryWrapper<Servicesupply>().like("city", key));
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,lists);
    }
}
