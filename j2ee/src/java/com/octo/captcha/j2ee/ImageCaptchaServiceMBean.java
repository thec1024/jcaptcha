/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2000 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Apache" and "Apache Software Foundation" must
 *    not be used to endorse or promote products derived from this
 *    software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    nor may "Apache" appear in their name, without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 *
 */
package com.octo.captcha.j2ee;

/**
 * Management Interface for the ImageCaptchaService
 *
 * @version $Id$
 *
 * @author <a href="mailto:sebastien.brunot@club-internet.fr">Sebastien Brunot</a>
 */
public interface ImageCaptchaServiceMBean
{
    /**
     * Get the fully qualified class name of the concrete ImageCaptchaEngine
     * used by the service.
     * @return the fully qualified class name of the concrete ImageCaptchaEngine
     * used by the service.
     */
    String getImageCaptchaEngineClass();

    /**
     * Set the fully qualified class name of the concrete ImageCaptchaEngine
     * used by the service
     * @param theClassName the fully qualified class name of the
     * ImageCaptchaEngine used by the service
     * @throws IllegalArgumentException if className can't be used as the
     * service ImageCaptchaEngine, either because it can't be instanciated
     * by the service or it is not a ImageCaptchaEngine concrete class.
     */
    void setImageCaptchaEngineClass(String theClassName)
        throws IllegalArgumentException;

    /**
     * Get the maximum number of captchas the service can
     * manage simulaneously.
     * @return the maximum number of captchas the service
     * can manage simultaneously
     */
    int getMaxNumberOfSimultaneousCaptchas();

    /**
     * Get the minimum delay (in seconds) a client can
     * be assured that a captcha generated by the service
     * can be retrieved and a response to its challenge
     * tested
     * @return the maximum delay in seconds
     */
    int getMinGuarantedStorageDelayInSeconds();

    /**
     * set the minimum delay (in seconds)a client can
     * be assured that a captcha generated by the service
     * can be retrieved and a response to its challenge
     * tested
     * @param theMinGuarantedStorageDelayInSeconds the
     * minimum guaranted delay
     */
    void setMinGuarantedStorageDelayInSeconds(
            int theMinGuarantedStorageDelayInSeconds);

    /**
     * Get the number of captcha generated since the service is up
     * WARNING : this value won't be significant if the real number
     * is > Long.MAX_VALUE
     * @return the number of captcha generated since the service is up
     */
    long getNumberOfGeneratedCaptchas();

    /**
     * Get the number of correct responses to captcha challenges since
     * the service is up.
     * WARNING : this value won't be significant if the real number
     * is > Long.MAX_VALUE
     * @return the number of correct responses since the service is up
     */
    long getNumberOfCorrectResponses();

    /**
     * Get the number of uncorrect responses to captcha challenges since
     * the service is up.
     * WARNING : this value won't be significant if the real number
     * is > Long.MAX_VALUE
     * @return the number of uncorrect responses since the service is up
     */
    long getNumberOfUncorrectResponses();

    /**
     * Get the load of the captcha store (number of current entries
     * / capacity of the store)
     * @return the load of the captcha store expressed in percent
     */
    double getCaptchaStoreLoad();

    /**
     * Get the number of captchas that can be garbage collected in
     * the captcha store
     * @return the number of captchas that can be garbage collected
     * in the captcha store
     */
    int getNumberOfGarbageCollectableCaptchas();

    /**
     * Get the number of captcha garbage collected since the service is up
     * WARNING : this value won't be significant if the real number
     * is > Long.MAX_VALUE
     * @return the number of captcha garbage collected since the service is up
     */
    long getNumberOfGarbageCollectedCaptcha();

    /**
     * Garbage collect the captcha store
     */
    void garbageCollectCaptchaStore();
}
