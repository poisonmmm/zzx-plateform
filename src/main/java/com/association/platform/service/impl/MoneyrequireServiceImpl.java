package com.association.platform.service.impl;

import com.association.platform.entity.Materialrequire;
import com.association.platform.entity.Moneyrequire;
import com.association.platform.mapper.MoneyrequireMapper;
import com.association.platform.service.IMoneyrequireService;
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
public class MoneyrequireServiceImpl extends ServiceImpl<MoneyrequireMapper, Moneyrequire> implements IMoneyrequireService {
    @SuppressWarnings("All")
    @Autowired
    MoneyrequireMapper moneyrequireMapper;

    public Result add(Moneyrequire moneyrequire){
        if (Objects.isNull(moneyrequire)){
            return new Result(ResultCode.FAIL.code, ResultMsg.ParameterMissing.msg);
        }
        moneyrequireMapper.insert(moneyrequire);
        return new Result(ResultCode.SUCCESS.code,ResultMsg.ApplySuccess.msg);
    }

    public Result delete(Moneyrequire moneyrequire){
        if (moneyrequire.getId().isEmpty()){
            return new Result(ResultCode.FAIL.code,ResultMsg.ParameterMissing.msg);
        }
        moneyrequireMapper.deleteById(moneyrequire.getId());
        return new Result(ResultCode.SUCCESS.code,ResultMsg.DeleteSuccess.msg,moneyrequire);
    }

    public Result showAll(){
        List<Moneyrequire> moneyrequires = moneyrequireMapper.selectList(null);
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,moneyrequires);
    }

    public Result searchByReceiveName(String key){
        List<Moneyrequire> lists = moneyrequireMapper.selectList(new QueryWrapper<Moneyrequire>().like("requirename", key));
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,lists);
    }



}

