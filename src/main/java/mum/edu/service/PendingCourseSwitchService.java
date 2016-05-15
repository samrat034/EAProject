package mum.edu.service;

import org.springframework.transaction.annotation.Transactional;

import mum.edu.dao.PendingCourseSwitchDAO;
import mum.edu.dao.RegistrationDao;
import mum.edu.dao.Registration_PreferedCoursesDAO;
import mum.edu.domain.PendingCourseSwitch;
import mum.edu.domain.Registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;

@Transactional(propagation = Propagation.REQUIRES_NEW)

public class PendingCourseSwitchService {

    @Autowired
    private PendingCourseSwitchDAO pendingSwitchDao;
    @Autowired
    private RegistrationDao registrationDao;
    @Autowired
    private Registration_PreferedCoursesDAO registration_PreferedCoursesDao;

    public List<PendingCourseSwitch> getAllPendingSwitches() {
        return pendingSwitchDao.findAll();
    }

    public void approve(int pendingSwitchId) {
        PendingCourseSwitch pendingSwitch = pendingSwitchDao.findOne(pendingSwitchId);
        Registration fromRegistration = pendingSwitch.getFromRegistration();
        registrationDao.save(new Registration(pendingSwitch.getUser(),  
        		  pendingSwitch.getToCourse(),pendingSwitch.getFromRegistration().getBlock()));
        pendingSwitchDao.delete(pendingSwitch);
        registration_PreferedCoursesDao.deleteInBatch(fromRegistration.getPreferedCourses());
        registrationDao.delete(fromRegistration);
    }

    public void reject(int pendingSwitchId) {
        pendingSwitchDao.delete(pendingSwitchId);
    }

}
