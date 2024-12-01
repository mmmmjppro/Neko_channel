package model;

import dao.MuttersDAO;

public class PostMutterLogic {

	public void execute(MutterBeans mutter) {
		MuttersDAO dao = new MuttersDAO();
		dao.create(mutter);
		
	}
}
