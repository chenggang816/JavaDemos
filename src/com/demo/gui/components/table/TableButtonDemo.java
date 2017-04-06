package com.demo.gui.components.table;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

public class TableButtonDemo {
	private JFrame frame;  
    private JTable table;  
	public static void main(String[] args)  
    {  
        EventQueue.invokeLater(new Runnable()  
        {  
            public void run()  
            {  
                try  
                {  
                	TableButtonDemo window = new TableButtonDemo();  
                    window.frame.setVisible(true);  
                }  
                catch (Exception e)  
                {  
                    e.printStackTrace();  
                }  
            }  
        });  
    }
	public TableButtonDemo() {
		this.initialize();
	}
	 /** 
     * Initialize the contents of the frame. 
     */  
    private void initialize()  
    {  
        this.frame = new JFrame("���ؼ���Ƕ��ť");  
        this.frame.setBounds(100, 100, 450, 300);  
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.frame.getContentPane().setLayout(null);  
  
        JPanel panel = new JPanel();  
        panel.setBounds(10, 10, 414, 242);  
        this.frame.getContentPane().add(panel);  
        panel.setLayout(null);  
  
        JScrollPane scrollPane = new JScrollPane();  
        scrollPane.setBounds(10, 10, 394, 222);  
        panel.add(scrollPane);  
  
        this.table = new JTable();  
        this.table.setRowHeight(70);
        scrollPane.setViewportView(this.table);  
  
        this.table.setModel(new DefaultTableModel()  
        {  
            @Override  
            public Object getValueAt(int row, int column)  
            {  
                return (row + 1) * (column + 1);  
            }  
  
            @Override  
            public int getRowCount()  
            {  
                return 5;  
            }  
  
            @Override  
            public int getColumnCount()  
            {  
                return 3;  
            }  
  
            @Override  
            public void setValueAt(Object aValue, int row, int column)  
            {  
                System.out.println(aValue + "  setValueAt");  
            }  
  
            @Override  
            public boolean isCellEditable(int row, int column)  
            {  
                // ���а�ť�еĹ����������Ҫ����true��Ȼ��ť���ʱ���ᴥ���༭Ч����Ҳ�Ͳ��ᴥ���¼���   
                if (column == 2)  
                {  
                    return true;  
                }  
                else  
                {  
                    return false;  
                }  
            }  
        });  
  
        this.table.getColumnModel().getColumn(2).setCellEditor(new MyButtonEditor(this.table));  
  
        this.table.getColumnModel().getColumn(2).setCellRenderer(new MyButtonRender());  
  
        this.table.setRowSelectionAllowed(false);// ��ֹ����ѡ���ܡ���Ȼ�ڵ����ťʱ�������ж��ᱻѡ�С�Ҳ����ͨ��������ʽ��ʵ�֡�   
    } 
}

class MyButtonRender implements TableCellRenderer
{
    private JPanel panel;
    private JButton button;
    public MyButtonRender()
    {
        this.initButton();
        this.initPanel();
        // ��Ӱ�ť��
        this.panel.add(this.button);
    }
    private void initButton()
    {
        this.button = new JButton();
        // ���ð�ť�Ĵ�С��λ�á�
        this.button.setBounds(0, 0, 100, 45);
        // ����Ⱦ�������Ӱ�ť���¼��ǲ��ᴥ����
        // this.button.addActionListener(new ActionListener()
        // {
        //
        // public void actionPerformed(ActionEvent e)
        // {
        // // TODO Auto-generated method stub
        // }
        // });
    }
    private void initPanel()
    {
        this.panel = new JPanel();
        // panelʹ�þ��Զ�λ������button�Ͳ������������Ԫ��
        this.panel.setLayout(null);
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
            int column)
    {
        // ֻΪ��ť��ֵ���ɡ�Ҳ������������������汳���ȡ�
//        this.button.setText(value == null ? "" : String.valueOf(value));
    	this.button.setText("ɾ��");
        return this.panel;
    }
}

/** 
 * �Զ���һ�����������Ӱ�ť�ĵ�Ԫ��༭������ü̳�DefaultCellEditor����ȻҪʵ�ֵķ�����̫���ˡ� 
 *  
 */  
class MyButtonEditor extends DefaultCellEditor  
{  
  
    /** 
     * serialVersionUID 
     */  
    private static final long serialVersionUID = -6546334664166791132L;  
  
    private JPanel panel;  
  
    private JButton button;  
  
    private JTable table;
    public MyButtonEditor(JTable table)  
    {  
        // DefautlCellEditor�д˹���������Ҫ����һ�������������ʹ�õ���ֱ��newһ�����ɡ�   
        super(new JTextField());  
  
        this.table = table;
        // ���õ�����μ���༭��   
        this.setClickCountToStart(1);  
  
        this.initButton();  
  
        this.initPanel();  
  
        // ��Ӱ�ť��   
        this.panel.add(this.button);  
    }  
  
    private void initButton()  
    {  
        this.button = new JButton();  
  
        // ���ð�ť�Ĵ�С��λ�á�   
        this.button.setBounds(0, 0, 100, 45);  
  
        // Ϊ��ť����¼�������ֻ�����ActionListner�¼���Mouse�¼���Ч��   
        this.button.addActionListener(new ActionListener()  
        {  
            public void actionPerformed(ActionEvent e)  
            {  
                // ����ȡ���༭���¼����������tableModel��setValue������   
                MyButtonEditor.this.fireEditingCanceled();  
                // �������������������   
                // ���Խ�table���룬ͨ��getSelectedRow,getSelectColumn������ȡ����ǰѡ����к��м����������ȡ�   
                System.out.println(table.getSelectedRow() + "," + table.getSelectedColumn());                
            }  
        });  
  
    }  
  
    private void initPanel()  
    {  
        this.panel = new JPanel();  
  
        // panelʹ�þ��Զ�λ������button�Ͳ������������Ԫ��   
        this.panel.setLayout(null);  
    }  
  
  
    /** 
     * ������д����ı༭����������һ��JPanel���󼴿ɣ�Ҳ����ֱ�ӷ���һ��Button���󣬵��������������������Ԫ�� 
     */  
    @Override  
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)  
    {  
        // ֻΪ��ť��ֵ���ɡ�Ҳ����������������   
        this.button.setText(value == null ? "" : String.valueOf(value));  
  
        return this.panel;  
    }  
  
    /** 
     * ��д�༭��Ԫ��ʱ��ȡ��ֵ���������д��������ܻ�Ϊ��ť���ô����ֵ�� 
     */  
    @Override  
    public Object getCellEditorValue()  
    {  
        return this.button.getText();  
    }  
  
} 