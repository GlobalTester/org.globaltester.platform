package org.globaltester.platform;

import static org.eclipse.swtbot.swt.finder.SWTBotAssert.assertMatchesRegex;

import org.globaltester.swtbot.Strings;
import org.globaltester.swtbot.uihelper.GlobalTesterUiHelper;
import org.junit.Test;

public class RcpIntegration{

	@Test
	public void testApplicationWindow() throws Exception {
		GlobalTesterUiHelper.init();
		assertMatchesRegex(Strings.WORKBENCH_TITLE, GlobalTesterUiHelper.getBot().activeShell().getText());
	}
}
