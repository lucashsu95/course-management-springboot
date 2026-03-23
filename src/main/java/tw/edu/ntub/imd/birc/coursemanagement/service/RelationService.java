package tw.edu.ntub.imd.birc.coursemanagement.service;

import tw.edu.ntub.imd.birc.coursemanagement.dto.bean.RelationBean;

public interface RelationService extends BaseService<RelationBean , String>{
    public void msgFunc(String st);
}
