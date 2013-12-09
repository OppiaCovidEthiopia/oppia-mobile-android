/* 
 * This file is part of OppiaMobile - http://oppia-mobile.org/
 * 
 * OppiaMobile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * OppiaMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with OppiaMobile. If not, see <http://www.gnu.org/licenses/>.
 */

package org.digitalcampus.oppia.widgets.quiz;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.digitalcampus.mobile.learning.R;
import org.digitalcampus.mobile.quiz.model.Response;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MultiSelectWidget extends QuestionWidget {

	public static final String TAG = MultiSelectWidget.class.getSimpleName();
	private LinearLayout responsesLL;
	
	public MultiSelectWidget(Activity activity, ViewGroup container) {
		init(activity,container,R.layout.widget_quiz_multiselect);
	}

	@Override
	public void setQuestionResponses(List<Response> responses, List<String> currentAnswer) {
		responsesLL = (LinearLayout) activity.findViewById(R.id.questionresponses);
    	responsesLL.removeAllViews();
    	
    	for (Response r : responses){
    		CheckBox chk= new CheckBox(ctx);  
    		chk.setText(r.getTitle());
    		responsesLL.addView(chk);
    		Iterator<String> itr = currentAnswer.iterator();
    		while(itr.hasNext()){
    			String a = itr.next(); 
    			if(a.equals(r.getTitle())){
    				chk.setChecked(true);
    			}
    		}
    	}	
	}

	@Override
	public List<String> getQuestionResponses(List<Response> responses) {
		int count = responsesLL.getChildCount();
		List<String> response = new ArrayList<String>();
		for (int i=0; i<count; i++) {
			CheckBox cb = (CheckBox) responsesLL.getChildAt(i);
			if(cb.isChecked()){
				response.add(cb.getText().toString());
			}
		}

		if(response.size() == 0){
			return null;
		} else {
			return response;
		}
	}

}
