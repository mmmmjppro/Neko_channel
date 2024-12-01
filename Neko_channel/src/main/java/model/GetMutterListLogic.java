package model;

import java.util.List;

import dao.MuttersDAO;

public class GetMutterListLogic {

	public List<MutterBeans> execute() {
		MuttersDAO dao = new MuttersDAO();
		List<MutterBeans> mutterList = dao.findAll();
		return mutterList;
	}
}
