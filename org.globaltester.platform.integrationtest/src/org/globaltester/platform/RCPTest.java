package org.globaltester.platform;

import static org.junit.Assert.assertNotNull;

import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.uihelper.GlobalTesterUiHelper;
import org.junit.Test;

public class RCPTest {

	@Test
	public void testApplicationWindow() throws Exception {
		GlobalTesterUiHelper.init();
		assertNotNull(GlobalTesterUiHelper.getBot().shell(Strings.WORKBENCH_TITLE));
	}
}