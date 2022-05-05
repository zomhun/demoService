package player.dao.impl;

import java.util.List;

import org.hibernate.Session;

import player.dao.PlayerDAO;
import player.entity.Player;
import player.util.HibernateUtil;

public class PlayerDAOImpl implements PlayerDAO{

	@Override
	public List<Player> getListPlayer() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			List list = session.createQuery("from Player").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Player getPlayerById(int playerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Player p = session.get(Player.class, playerId);
			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertPlayer(Player player) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(player);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updatePlayer(Player player) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(player);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deletePlayer(int playerId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.delete(getPlayerById(playerId));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Player> getPlayerByClubName(String clubName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			if(clubName==null||clubName.length()==0) {
				clubName="%";
			}else {
				clubName="%"+clubName+"%";
			}
			List list = session.createQuery("from Player where clubName like :clubName").setParameter("clubName", clubName).list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
