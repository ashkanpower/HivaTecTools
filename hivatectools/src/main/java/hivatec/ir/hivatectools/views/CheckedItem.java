package hivatec.ir.hivatectools.views;

/**
 * Created by ashkan on 7/7/18.
 */

public interface CheckedItem {

	int getId();
	String getTitle();
	boolean isChecked();
	void setChecked(Boolean checked);
}
