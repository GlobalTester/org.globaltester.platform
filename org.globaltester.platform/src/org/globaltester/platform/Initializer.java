package org.globaltester.platform;

import org.eclipse.ui.IStartup;
import org.globaltester.PlatformHelper;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

public class Initializer implements IStartup {
	
	@Override
	public void earlyStartup()  {
		BundleContext bc = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
		PlatformHelper.startBundle(org.globaltester.control.soap.Activator.class.getPackage().getName(), bc);
	}
}
