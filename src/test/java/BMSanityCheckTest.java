/* BMSanityCheckTests.java */
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.jboss.byteman.contrib.bmunit.BMRule;
import org.jboss.byteman.contrib.bmunit.BMRules;
import org.jboss.byteman.contrib.bmunit.BMUnitConfig;
import org.jboss.byteman.contrib.bmunit.BMUnitRunner;

@RunWith(BMUnitRunner.class)
public class BMSanityCheckTest
{

    @Test
    @BMUnitConfig(debug = true, verbose = true, bmunitVerbose = true)
    @BMRules(rules = {@BMRule (name="rule",
                              targetClass = "BMSanityHelper",
                              targetMethod = "doSomething",
                              targetLocation = "AT ENTRY",
                              action = "BMSanityHelper.ack()" )})
    public void name()
    {
        BMSanityHelper helper = new BMSanityHelper();
        Assert.assertFalse(helper.wasAcked);
        helper.doSomething();

        Assert.assertTrue(helper.wasAcked);

    }
}
