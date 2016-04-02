package org.androidpn.server.dao.hibernate;

import java.util.List;

import org.androidpn.server.dao.NotificationDao;
import org.androidpn.server.model.Notification;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NotificationDaoHibernate extends HibernateDaoSupport implements NotificationDao{

	public void saveNotification(Notification notification) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(notification);
		getHibernateTemplate().flush();
	}

	public void deleteNotification(Notification notification) {
		// TODO Auto-generated method stub
		getHibernateTemplate().delete(notification);
	}

	public List<Notification> findNotificationsByUserName(String username) {
		// TODO Auto-generated method stub
		
		@SuppressWarnings("unchecked")
		List<Notification> listNotification = getHibernateTemplate().find("from Notification where username=?",username);
		if(listNotification!=null && listNotification.size()>0){
			return listNotification;
		}
		return null;
	}

	public void deleteNotificationByUUID(String uuid) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		List<Notification> listNotification = getHibernateTemplate().find("from Notification where username=?",uuid);
		if(listNotification!=null && listNotification.size()>0){
			Notification notification = listNotification.get(0);
			deleteNotification(notification);
		}
	}

}
