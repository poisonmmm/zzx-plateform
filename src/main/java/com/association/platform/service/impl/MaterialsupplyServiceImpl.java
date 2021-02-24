package com.association.platform.service.impl;

import com.association.platform.entity.Materialrequire;
import com.association.platform.entity.Materialsupply;
import com.association.platform.mapper.MaterialsupplyMapper;
import com.association.platform.service.IMaterialsupplyService;
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
public class MaterialsupplyServiceImpl extends ServiceImpl<MaterialsupplyMapper, Materialsupply> implements IMaterialsupplyService {
    @SuppressWarnings("All")
    @Autowired
    MaterialsupplyMapper materialsupplyMapper;

    public Result add(Materialsupply materialsupply){
        if (Objects.isNull(materialsupply)){
            return new Result(ResultCode.FAIL.code, ResultMsg.ParameterMissing.msg);
        }
        materialsupplyMapper.insert(materialsupply);
        return new Result(ResultCode.SUCCESS.code,ResultMsg.ApplySuccess.msg,materialsupply);
    }
    public Result delete(Materialsupply materialsupply){
        if (materialsupply.getId().isEmpty()){
            return new Result(ResultCode.FAIL.code,ResultMsg.ParameterMissing.msg);
        }
        materialsupplyMapper.deleteById(materialsupply.getId());
        return new Result(ResultCode.SUCCESS.code,ResultMsg.DeleteSuccess.msg,materialsupply);
    }
    public Result showAll(){
        List<Materialsupply> materialsupplies = materialsupplyMapper.selectList(null);
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,materialsupplies);
    }

    public Result searchByName(String key){
        List<Materialsupply> lists = materialsupplyMapper.selectList(new QueryWrapper<Materialsupply>().like("name", key));
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,lists);
    }

}
