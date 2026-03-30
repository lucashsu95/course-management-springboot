package tw.edu.ntub.imd.birc.coursemanagement.service;

import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.CourseBean;

public interface CourseService extends BaseService<CourseBean,String>{

    public void msgFunc(String st);
}
