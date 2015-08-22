/*
 * Hyperbox - Virtual Infrastructure Manager
 * Copyright (C) 2013 Maxime Dor
 * hyperbox at altherian dot org
 * 
 * http://kamax.io/hbox/
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package io.kamax.hboxc.gui.action.security;

import io.kamax.hbox.comm.Command;
import io.kamax.hbox.comm.HyperboxTasks;
import io.kamax.hbox.comm.Request;
import io.kamax.hbox.comm.in.ServerIn;
import io.kamax.hbox.comm.in.UserIn;
import io.kamax.hboxc.gui.Gui;
import io.kamax.hboxc.gui.builder.IconBuilder;
import io.kamax.hboxc.gui.security.user.UserEditor;
import io.kamax.hboxc.gui.server._SingleServerSelector;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class UserCreateAction extends AbstractAction {

    private static final long serialVersionUID = 2144369747211508591L;
    private _SingleServerSelector select;

    public UserCreateAction(_SingleServerSelector select) {
        this(select, "Create");
    }

    public UserCreateAction(_SingleServerSelector select, String label) {
        super(label, IconBuilder.getTask(HyperboxTasks.UserCreate));
        this.select = select;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        UserIn usrIn = UserEditor.getInput();
        if (usrIn != null) {
            Gui.post(new Request(Command.HBOX, HyperboxTasks.UserCreate, new ServerIn(select.getServer()), usrIn));
        }
    }

}
