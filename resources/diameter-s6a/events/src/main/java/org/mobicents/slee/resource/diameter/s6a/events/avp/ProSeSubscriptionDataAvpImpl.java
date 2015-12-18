/*
 * JBoss, Home of Professional Open Source
 * Copyright 2011, Red Hat, Inc. and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.mobicents.slee.resource.diameter.s6a.events.avp;

import net.java.slee.resource.diameter.s6a.events.avp.DiameterS6aAvpCodes;
import net.java.slee.resource.diameter.s6a.events.avp.ProSESubscriptionDataAvp;
import net.java.slee.resource.diameter.s6a.events.avp.ProSeAllowedPLMNAvp;
import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * Implementation for {@link net.java.slee.resource.diameter.s6a.events.avp.MOLRAvp}
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 * @author <a href="mailto:baranowb@gmail.com"> Bartosz Baranowski </a>
 * @author <a href="mailto:richard.good@smilecoms.com"> Richard Good </a>
 * @author <a href="mailto:paul.carter-brown@smilecoms.com"> Paul Carter-Brown </a>
 */
public class ProSeSubscriptionDataAvpImpl extends GroupedAvpImpl implements ProSESubscriptionDataAvp {

    public ProSeSubscriptionDataAvpImpl() {
        super();
    }

    public ProSeSubscriptionDataAvpImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
        super(code, vendorId, mnd, prt, value);
    }

    public boolean hasProSePermission() {
        return hasAvp(DiameterS6aAvpCodes.PROSE_PERMISSION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public long getProSePermission() {
        return getAvpAsUnsigned32(DiameterS6aAvpCodes.PROSE_PERMISSION, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void setProSePermission(long proSePermission) {
       addAvp(DiameterS6aAvpCodes.PROSE_PERMISSION, DiameterS6aAvpCodes.S6A_VENDOR_ID, proSePermission);
    }

    public boolean hasProSeAllowedPLMN() {
        return hasAvp(DiameterS6aAvpCodes.PROSE_ALLOWED_PLMN, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public ProSeAllowedPLMNAvp getProSeAllowedPLMN() {
        return (ProSeAllowedPLMNAvp) getAvpAsCustom(DiameterS6aAvpCodes.PROSE_ALLOWED_PLMN,
                                                    DiameterS6aAvpCodes.S6A_VENDOR_ID, ProSeAllowedPLMNAvpImpl.class);
    }

    public void setProSeAllowedPLMN(ProSeAllowedPLMNAvp proSeAllowedPLMN) {
        addAvp(proSeAllowedPLMN);
    }

    public boolean has3GPPChargingCharacteristics() {
        return hasAvp(DiameterS6aAvpCodes.TGPP_CHARGING_CHARACTERISTICS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public String get3GPPChargingCharacteristics() {
        return getAvpAsUTF8String(DiameterS6aAvpCodes.TGPP_CHARGING_CHARACTERISTICS, DiameterS6aAvpCodes.S6A_VENDOR_ID);
    }

    public void set3GPPChargingCharacteristics(String threeGPPChargingCharacteristics) {
        addAvp(DiameterS6aAvpCodes.TGPP_CHARGING_CHARACTERISTICS, DiameterS6aAvpCodes.S6A_VENDOR_ID, threeGPPChargingCharacteristics);
    }
}