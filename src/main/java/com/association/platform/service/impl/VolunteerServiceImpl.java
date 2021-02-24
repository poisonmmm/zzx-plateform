package com.association.platform.service.impl;

import com.association.platform.entity.Servicesupply;
import com.association.platform.entity.Volunteer;
import com.association.platform.mapper.VolunteerMapper;
import com.association.platform.service.IVolunteerService;
import com.association.platform.util.Result;
import com.association.platform.util.ResultCode;
import com.association.platform.util.ResultMsg;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.cert.X509Certificate;
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
public class VolunteerServiceImpl extends ServiceImpl<VolunteerMapper, Volunteer> implements IVolunteerService {
    @SuppressWarnings("All")
    @Autowired
    private VolunteerMapper volunteerMapper;

    public Result addVolunteer(Volunteer volunteer){
        if (Objects.isNull(volunteer)){
            return new Result(ResultCode.FAIL.code, ResultMsg.ParameterMissing.msg);
        }
        volunteerMapper.insert(volunteer);
        return new Result(ResultCode.SUCCESS.code,ResultMsg.ApplySuccess.msg);
    }

    public Result showAllVolunteer(){
        List<Volunteer> volunteers = volunteerMapper.selectList(null);
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,volunteers);
    }

    public Result deleteVolunteer(Volunteer volunteer){
        if (volunteer.getId().isEmpty()){
            return new Result(ResultCode.FAIL.code,ResultMsg.ParameterMissing.msg);
        }
        volunteerMapper.deleteById(volunteer.getId());
        return new Result(ResultCode.SUCCESS.code,ResultMsg.DeleteSuccess.msg,volunteer);
    }

    public Result searchByName(String key){
        List<Volunteer> lists = volunteerMapper.selectList(new QueryWrapper<Volunteer>().like("name", key));
        return new Result(ResultCode.SUCCESS.code,ResultMsg.OK.msg,lists);
    }
}
