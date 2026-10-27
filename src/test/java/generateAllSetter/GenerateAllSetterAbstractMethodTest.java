/*
 *  Copyright (c) 2017-2019, bruce.ge.
 *    This program is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU General Public License
 *    as published by the Free Software Foundation; version 2 of
 *    the License.
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *    GNU General Public License for more details.
 *    You should have received a copy of the GNU General Public License
 *    along with this program;
 */

package generateAllSetter;

import com.bruce.intellijplugin.generatesetter.CommonConstants;
import org.assertj.core.api.Assertions;

public class GenerateAllSetterAbstractMethodTest extends BaseTest {

    public void testInterfaceMethodWithoutBodyIsNotAvailable() {
        myFixture.configureByText("Animal.java",
                "interface Animal {\n" +
                "    User getUser();\n" +
                "}\n" +
                "class User {\n" +
                "    public void setName(String name) {}\n" +
                "}\n");

        Assertions.assertThat(
                myFixture.getAvailableIntention(CommonConstants.GENERATE_CONVERTER_FROM_METHOD)
        ).isNull();
    }

    public void testAbstractMethodWithoutBodyIsNotAvailable() {
        myFixture.configureByText("Animal.java",
                "abstract class Animal {\n" +
                "    abstract User getUser();\n" +
                "}\n" +
                "class User {\n" +
                "    public void setName(String name) {}\n" +
                "}\n");

        Assertions.assertThat(
                myFixture.getAvailableIntention(CommonConstants.GENERATE_CONVERTER_FROM_METHOD)
        ).isNull();
    }
}
