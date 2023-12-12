/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code, in source
 * and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *****************************************************************************/
package com.devamatre.theorem.domain.service.common;

/**
 * @author Rohtash Lakra
 * @date 10/12/2016 04:55:40 PM
 */
public class Circle {

    // Horizontal position of center
    int xValue;
    // Vertical position of center
    int yValue;

    float radius;
    // True means circle filled
    boolean solid;

    public Circle() {

    }

    /**
     * @return the xValue
     */
    public int getXValue() {
        return xValue;
    }

    /**
     * @param xValue the xValue to set
     */
    public void setXValue(int xValue) {
        this.xValue = xValue;
    }

    /**
     * @return the yValue
     */
    public int getYValue() {
        return yValue;
    }

    /**
     * @param yValue the yValue to set
     */
    public void setYValue(int yValue) {
        this.yValue = yValue;
    }

    /**
     * @return the radius
     */
    public float getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * @return the solid
     */
    public boolean isSolid() {
        return solid;
    }

    /**
     * @param solid the solid to set
     */
    public void setSolid(boolean solid) {
        this.solid = solid;
    }
}
