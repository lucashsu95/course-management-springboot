package tw.edu.ntub.imd.birc.coursemanagement.service;

import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.StudentBean;

public interface StudentService extends BaseService<StudentBean, String>{

    public void msgFunc(String st);
}
