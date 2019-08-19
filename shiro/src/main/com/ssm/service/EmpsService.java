package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.bean.TblEmp;
import ssm.dao.TblEmpMapper;

import java.util.Arrays;
import java.util.List;

@Service
public class EmpsService {


    @Autowired
    TblEmpMapper tblEmpMapper;

    public List<TblEmp>  getEmps(){
        return  tblEmpMapper.selectByExampleWithDept(null);
    }


    public List test(){
        double[] aa = {1,2,3,4,5,6,7,8,9,40};
        return  Arrays.asList(aa);
    }
}
