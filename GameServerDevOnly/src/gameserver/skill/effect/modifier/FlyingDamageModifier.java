/*
 * This file is part of aion-unique <aion-unique.org>.
 *
 *  aion-unique is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-unique is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-unique.  If not, see <http://www.gnu.org/licenses/>.
 */

package gameserver.skill.effect.modifier;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import gameserver.model.gameobjects.player.Player;
import gameserver.skill.model.Effect;




/**
 * @author kecimis
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FlyingDamageModifier")
public class FlyingDamageModifier
extends ActionModifier
{
    @Override
    public int analyze(Effect effect)
    {      
        return (value + effect.getSkillLevel() * delta);
    }

    @Override
    public boolean check(Effect effect)
    {
        if (!(effect.getEffected() instanceof Player))
            return false;
        else 
            return ((Player)effect.getEffected()).getFlyState() == 1;
    }
}