package com.app.entity;

import org.hibernate.Session;

public class Test {

	
	public void save() {
		Person per=new Person();
		per.setName("Rutuja");
		per.setMobile("7365367321");
		
		Pancard pan=new Pancard();
		pan.setPancardno("FGJ6438");
		
		pan.setPerson(per);
		per.setPancard(pan);
		
		Session session = HibernateUtility.getSession().openSession();
		session.save(pan);
		session.beginTransaction().commit();
		System.out.println("Success");
		
	}
	
	@SuppressWarnings("unchecked")
	public void selectAll() {
		HibernateUtility.getSession().openSession().createCriteria(Person.class).list().forEach(System.out::println);
	}
	
	public void update() {
		Session session = HibernateUtility.getSession().openSession();
		Person per=(Person) session.get(Person.class, 11);
		per.setName("Dipali");
		
		Pancard pan=per.getPancard();
		pan.setPancardno("GJKJ57236");
		pan.setPerson(per);
		per.setPancard(pan);
		
		session.update(per);
		
		session.beginTransaction().commit();
		System.out.println("Successfully updated");
	}
	
	public void delete() {
		Session session =HibernateUtility.getSession().openSession();
		Person per=(Person) session.get(Person.class, 11);
		session.delete(per);
		session.beginTransaction().commit();
		System.out.println("Deleted");
	}
	
	
	
	public static void main(String[] args) {
		Test t=new Test();
		t.save();
		t.selectAll();
		//t.update();
		//t.delete();
	}
}
