package all_frame;

import javax.swing.JTable;

class MyTable extends JTable{
	private static final long serialVersionUID = 1L;
	int column;
	MyTable(Object[][] a,Object[] lm,int c )
	{
	    super(a,lm);
	    column=c;
	    getTableHeader().setReorderingAllowed(false);
	}
	public boolean isCellEditable(int row,int c)
	{   
		if(c==column)
		    return true;
		else
			return false;
    }
}
