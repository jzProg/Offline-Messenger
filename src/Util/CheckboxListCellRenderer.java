package Util;

import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 * @param <E>
 */
@SuppressWarnings("serial")
public class CheckboxListCellRenderer<E> extends JCheckBox implements ListCellRenderer<E> {
	
	public Component getListCellRendererComponent(JList<? extends E> list, E value, int index, boolean isSelected, boolean cellHasFocus) {

        setComponentOrientation(list.getComponentOrientation());
        setFont(list.getFont());
        setBackground(list.getBackground());
        setForeground(list.getForeground());
        setSelected(isSelected);
        setEnabled(list.isEnabled());

        setText(value == null ? "" : value.toString());  

        return this;
	}
}