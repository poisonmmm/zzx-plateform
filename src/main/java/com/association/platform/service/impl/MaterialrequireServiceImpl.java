package com.association.platform.service.impl;

import com.association.platform.entity.Materialrequire;
import com.association.platform.mapper.MaterialrequireMapper;
import com.association.platform.service.IMaterialrequireService;
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
public class MaterialrequireServiceImpl extends ServiceImpl<MaterialrequireMapper, Materialrequire> implements IMaterialrequireService {

    @SuppressWarnings("All")
    @Autowired
    MaterialrequireMapper materialrequireMapper;

    public Result insert(Materialrequire materialrequire){
        if (Objects.isNull(materialrequire)){
            return new Result(ResultCode.FAIL.code,ResultMsg.ParameterMissing.msg);
        }
        materialrequireMapper.insert(materialrequire);
        return new Result(ResultCode.SUCCESS.code,ResultMsg.ApplySuccess.msg,materialrequire);
    }

    public Result delete(Materialrequire materialrequire){
        if (materialrequire.getId().isEmpty()){
            return new Result(ResultCode.FAIL.code,ResultMsg.ParameterMissing.msg);
        }
        materialrequireMapper.deleteById(materialrequire.getId());
        return new Result(ResultCode.SUCCESS.code,ResultMsg.DeleteSuccess.msg,materialrequire);
    }

    public Result showAll(){
        List<Materialrequire> materialrequires = materialrequireMapper.selectList(null);
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,materialrequires);
    }
    public Result searchByReceiveName(String key){
        List<Materialrequire> lists = materialrequireMapper.selectList(new QueryWrapper<Materialrequire>().like("receivename", key));
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,lists);
    }
}
