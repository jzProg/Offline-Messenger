package ui.mainApp;

import java.util.Set;

import ui.View;
import Domain.Conversation;

/**
 * Main window view
 * @author Vlassis Ioannis, Zagarelos Ioannis
 *
 */
public interface MainWindowView extends View {

	/**
	 * Set conversations list to view
	 * @param list conversation list
	 */
	public void setConvList(Set<Conversation> list);

	/**
	 * Set presenter to view
	 * @param presenter presenter
	 */
	public void setPresenter(MainWindowPresenter presenter);
}
