package ssm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.bean.TblEmp;
import ssm.dao.TblEmpMapper;

import java.util.Arrays;
import java.util.List;

@Service
public class Test {


    public static void main(String[] args) {
        int total = 100;
        int singlePage = 3;
        int pageNum = 100 / 3 + (total%singlePage != 0 ? 1:0 );
        System.out.println(pageNum);
    }



    public List test(){
        double[] aa = {1,2,3,4,5,6,7,8,9,40};
        return  Arrays.asList(aa);
    }
}
