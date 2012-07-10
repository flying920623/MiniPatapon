package game.minipatapon.effectpresent.action;

public class Easing {
	/*
	Disclaimer for Robert Penner's Easing Equations license:

	TERMS OF USE - EASING EQUATIONS

	Open source under the BSD License.

	Copyright 漏 2001 Robert Penner
	All rights reserved.

	Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:

	    * Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
	    * Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
	    * Neither the name of the author nor the names of contributors may be used to endorse or promote products derived from this software without specific prior written permission.

	THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
	*/


	static float M_PI  = 3.14159265358979323846f;

	static float M_PI_2  = (M_PI / 2f);
	


	/**
	 * Easing equation function for a simple linear tweening, with no easing.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeNone(float progress)
	{
	    return progress;
	}

	/**
	 * Easing equation function for a quadratic (t^2) easing in: accelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInQuad(float t)
	{
	    return t*t;
	}

	/**
	* Easing equation function for a quadratic (t^2) easing out: decelerating to zero velocity.
	*
	* @param t		Current time (in frames or seconds).
	* @return		The correct value.
	*/
	static float easeOutQuad(float t)
	{
	    return -t*(t-2f);
	}

	/**
	 * Easing equation function for a quadratic (t^2) easing in/out: acceleration until halfway, then deceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInOutQuad(float t)
	{
	    t*=2.0f;
	    if (t < 1) {
	        return t*t/2f;
	    } else {
	        --t;
	        return -0.5f * (t*(t-2f) - 1f);
	    }
	}

	/**
	 * Easing equation function for a quadratic (t^2) easing out/in: deceleration until halfway, then acceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutInQuad(float t)
	{
	    if (t < 0.5f) return easeOutQuad (t*2f)/2f;
	    return easeInQuad((2f*t)-1)/2f + 0.5f;
	}

	/**
	 * Easing equation function for a cubic (t^3) easing in: accelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInCubic(float t)
	{
	    return t*t*t;
	}

	/**
	 * Easing equation function for a cubic (t^3) easing out: decelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutCubic(float t)
	{
	    t-=1.0f;
	    return t*t*t + 1;
	}

	/**
	 * Easing equation function for a cubic (t^3) easing in/out: acceleration until halfway, then deceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInOutCubic(float t)
	{
	    t*=2.0f;
	    if(t < 1) {
	        return 0.5f*t*t*t;
	    } else {
	        t -= 2.0f;
	        return 0.5f*(t*t*t + 2f);
	    }
	}

	/**
	 * Easing equation function for a cubic (t^3) easing out/in: deceleration until halfway, then acceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutInCubic(float t)
	{
	    if (t < 0.5f) return easeOutCubic (2f*t)/2f;
	    return easeInCubic(2f*t - 1)/2 + 0.5f;
	}

	/**
	 * Easing equation function for a quartic (t^4) easing in: accelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInQuart(float t)
	{
	    return t*t*t*t;
	}

	/**
	 * Easing equation function for a quartic (t^4) easing out: decelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutQuart(float t)
	{
	    t-= 1.0f;
	    return - (t*t*t*t- 1f);
	}

	/**
	 * Easing equation function for a quartic (t^4) easing in/out: acceleration until halfway, then deceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInOutQuart(float t)
	{
	    t*=2f;
	    if (t < 1) return 0.5f*t*t*t*t;
	    else {
	        t -= 2.0f;
	        return -0.5f * (t*t*t*t- 2f);
	    }
	}

	/**
	 * Easing equation function for a quartic (t^4) easing out/in: deceleration until halfway, then acceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutInQuart(float t)
	{
	    if (t < 0.5f) return easeOutQuart (2f*t)/2f;
	    return easeInQuart(2f*t-1)/2f + 0.5f;
	}

	/**
	 * Easing equation function for a quintic (t^5) easing in: accelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInQuint(float t)
	{
	    return t*t*t*t*t;
	}

	/**
	 * Easing equation function for a quintic (t^5) easing out: decelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutQuint(float t)
	{
	    t-=1.0f;
	    return t*t*t*t*t + 1f;
	}

	/**
	 * Easing equation function for a quintic (t^5) easing in/out: acceleration until halfway, then deceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInOutQuint(float t)
	{
	    t*=2.0f;
	    if (t < 1f) return 0.5f*t*t*t*t*t;
	    else {
	        t -= 2.0f;
	        return 0.5f*(t*t*t*t*t + 2f);
	    }
	}

	/**
	 * Easing equation function for a quintic (t^5) easing out/in: deceleration until halfway, then acceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutInQuint(float t)
	{
	    if (t < 0.5f) return easeOutQuint (2f*t)/2f;
	    return easeInQuint(2f*t - 1)/2f + 0.5f;
	}

	/**
	 * Easing equation function for a sinusoidal (sin(t)) easing in: accelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInSine(float t)
	{
	    return  ((t == 1.0f) ? 1.0f : (float)-Math.cos(t * M_PI_2) + 1.0f);
	}

	/**
	 * Easing equation function for a sinusoidal (sin(t)) easing out: decelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutSine(float t)
	{
	    return (float) Math.sin(t* M_PI_2);
	}

	/**
	 * Easing equation function for a sinusoidal (sin(t)) easing in/out: acceleration until halfway, then deceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInOutSine(float t)
	{
	    return  (-0.5f * ((float)Math.cos(M_PI*t) - 1));
	}

	/**
	 * Easing equation function for a sinusoidal (sin(t)) easing out/in: deceleration until halfway, then acceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutInSine(float t)
	{
	    if (t < 0.5f) return easeOutSine (2*t)/2;
	    return easeInSine(2*t - 1)/2 + 0.5f;
	}

	/**
	 * Easing equation function for an exponential (2^t) easing in: accelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInExpo(float t)
	{
	    return  ((t==0 || t == 1.0) ? t : (float)Math.pow(2.0, 10 * (t - 1)) - 0.001f);
	}

	/**
	 * Easing equation function for an exponential (2^t) easing out: decelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutExpo(float t)
	{
	    return (t==1.0f) ? 1.0f : 1.001f * (-(float)Math.pow(2.0f, -10 * t) + 1);
	}

	/**
	 * Easing equation function for an exponential (2^t) easing in/out: acceleration until halfway, then deceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInOutExpo(float t)
	{
	    if (t==0.0) return 0.0f;
	    if (t==1.0) return 1.0f;
	    t*=2.0;
	    if (t < 1) return 0.5f * (float)Math.pow(2.0f, 10 * (t - 1)) - 0.0005f;
	    return 0.5f * 1.0005f * (-(float)Math.pow(2.0f, -10 * (t - 1)) + 2);
	}

	/**
	 * Easing equation function for an exponential (2^t) easing out/in: deceleration until halfway, then acceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutInExpo(float t)
	{
	    if (t < 0.5) return easeOutExpo (2*t)/2;
	    return easeInExpo(2*t - 1)/2 + 0.5f;
	}

	/**
	 * Easing equation function for a circular (sqrt(1-t^2)) easing in: accelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInCirc(float t)
	{
	    return (float) -(Math.sqrt(1 - t*t) - 1);
	}

	/**
	 * Easing equation function for a circular (sqrt(1-t^2)) easing out: decelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutCirc(float t)
	{
	    t-= 1.0f;
	    return (float) Math.sqrt(1 - t* t);
	}

	/**
	 * Easing equation function for a circular (sqrt(1-t^2)) easing in/out: acceleration until halfway, then deceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeInOutCirc(float t)
	{
	    t*=2.0f;
	    if (t < 1) {
	        return -0.5f * ((float)Math.sqrt(1 - t*t) - 1);
	    } else {
	        t -= 2.0f;
	        return 0.5f * ((float)Math.sqrt(1 - t*t) + 1);
	    }
	}

	/**
	 * Easing equation function for a circular (sqrt(1-t^2)) easing out/in: deceleration until halfway, then acceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @return		The correct value.
	 */
	static float easeOutInCirc(float t)
	{
	    if (t < 0.5) return easeOutCirc (2*t)/2;
	    return easeInCirc(2*t - 1)/2 + 0.5f;
	}

	static float easeInElastic_helper(float t, float b, float c, float d, float a, float p)
	{
	    if (t==0) return b;
	    float t_adj = (float)t / (float)d;
	    if (t_adj==1) return b+c;

	    float s;
	    if(a < Math.abs(c)) {
	        a = c;
	        s = p / 4.0f;
	    } else {
	        s = p / (2f * M_PI) * (float)Math.asin(c / a);
	    }

	    t_adj -= 1.0f;
	    return -(a*(float)Math.pow(2.0f,10*t_adj) * (float)Math.sin( (t_adj*d-s)*(2*M_PI)/p )) + b;
	}

	/**
	 * Easing equation function for an elastic (exponentially decaying sine wave) easing in: accelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param a		Amplitude.
	 * @param p		Period.
	 * @return		The correct value.
	 */
	static float easeInElastic(float t, float a, float p)
	{
	    return easeInElastic_helper(t, 0, 1, 1, a, p);
	}

	static float easeOutElastic_helper(float t, float b, float c, float d, float a, float p)
	{
	    if (t==0) return 0;
	    if (t==1) return c;

	    float s;
	    if(a < c) {
	        a = c;
	        s = p / 4.0f;
	    } else {
	        s = p / (2 * M_PI) * (float)Math.asin(c / a);
	    }

	    return (a*(float)Math.pow(2.0f,-10*t) * (float)Math.sin( (t-s)*(2*M_PI)/p ) + c);
	}

	/**
	 * Easing equation function for an elastic (exponentially decaying sine wave) easing out: decelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param a		Amplitude.
	 * @param p		Period.
	 * @return		The correct value.
	 */
	static float easeOutElastic(float t, float a, float p)
	{
	    return easeOutElastic_helper(t, 0, 1, 1, a, p);
	}

	/**
	 * Easing equation function for an elastic (exponentially decaying sine wave) easing in/out: acceleration until halfway, then deceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param a		Amplitude.
	 * @param p		Period.
	 * @return		The correct value.
	 */
	static float easeInOutElastic(float t, float a, float p)
	{
	    if (t==0) return 0.0f;
	    t*=2.0;
	    if (t==2) return 1.0f;

	    float s;
	    if(a < 1.0f) {
	        a = 1.0f;
	        s = p / 4.0f;
	    } else {
	        s = p / (2 * M_PI) * (float)Math.asin(1.0 / a);
	    }

	    if (t < 1) return -.5f*(a*(float)Math.pow(2.0f,10*(t-1)) * (float)Math.sin( (t-1-s)*(2*M_PI)/p ));
	    return a*(float)Math.pow(2.0f,-10*(t-1)) * (float)Math.sin( (t-1-s)*(2*M_PI)/p )*.5f + 1.0f;
	}

	/**
	 * Easing equation function for an elastic (exponentially decaying sine wave) easing out/in: deceleration until halfway, then acceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param a		Amplitude.
	 * @param p		Period.
	 * @return		The correct value.
	 */
	static float easeOutInElastic(float t, float a, float p)
	{
	    if (t < 0.5) return easeOutElastic_helper(t*2, 0f, 0.5f, 1.0f, a, p);
	    return easeInElastic_helper(2*t - 1.0f, 0.5f, 0.5f, 1.0f, a, p);
	}

	/**
	 * Easing equation function for a back (overshooting cubic easing: (s+1)*t^3 - s*t^2) easing in: accelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param s		Overshoot ammount: higher s means greater overshoot (0 produces cubic easing with no overshoot, and the default value of 1.70158 produces an overshoot of 10 percent).
	 * @return		The correct value.
	 */
	static float easeInBack(float t, float s)
	{
	    return t*t*((s+1)*t - s);
	}

	/**
	 * Easing equation function for a back (overshooting cubic easing: (s+1)*t^3 - s*t^2) easing out: decelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param s		Overshoot ammount: higher s means greater overshoot (0 produces cubic easing with no overshoot, and the default value of 1.70158 produces an overshoot of 10 percent).
	 * @return		The correct value.
	 */
	static float easeOutBack(float t, float s)
	{
	    t-= 1.0f;
	    return t*t*((s+1)*t+ s) + 1;
	}

	/**
	 * Easing equation function for a back (overshooting cubic easing: (s+1)*t^3 - s*t^2) easing in/out: acceleration until halfway, then deceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param s		Overshoot ammount: higher s means greater overshoot (0 produces cubic easing with no overshoot, and the default value of 1.70158 produces an overshoot of 10 percent).
	 * @return		The correct value.
	 */
	static float easeInOutBack(float t, float s)
	{
	    t *= 2.0;
	    if (t < 1) {
	        s *= 1.525f;
	        return 0.5f*(t*t*((s+1)*t - s));
	    } else {
	        t -= 2;
	        s *= 1.525f;
	        return 0.5f*(t*t*((s+1)*t+ s) + 2);
	    }
	}

	/**
	 * Easing equation function for a back (overshooting cubic easing: (s+1)*t^3 - s*t^2) easing out/in: deceleration until halfway, then acceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param s		Overshoot ammount: higher s means greater overshoot (0 produces cubic easing with no overshoot, and the default value of 1.70158 produces an overshoot of 10 percent).
	 * @return		The correct value.
	 */
	static float easeOutInBack(float t, float s)
	{
	    if (t < 0.5) return easeOutBack (2*t, s)/2;
	    return easeInBack(2*t - 1, s)/2 + 0.5f;
	}

	static float easeOutBounce_helper(float t, float c, float a)
	{
	    if (t == 1.0) return c;
	    if (t < (4/11.0)) {
	        return c*(7.5625f*t*t);
	    } else if (t < (8/11.0)) {
	        t -= (6/11.0);
	        return -a * (1.f - (7.5625f*t*t + .75f)) + c;
	    } else if (t < (10/11.0)) {
	        t -= (9/11.0);
	        return -a * (1.f - (7.5625f*t*t + .9375f)) + c;
	    } else {
	        t -= (21/22.0);
	        return -a * (1.f - (7.5625f*t*t + .984375f)) + c;
	    }
	}

	/**
	 * Easing equation function for a bounce (exponentially decaying parabolic bounce) easing out: decelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param a		Amplitude.
	 * @return		The correct value.
	 */
	static float easeOutBounce(float t, float a)
	{
	    return easeOutBounce_helper(t, 1, a);
	}

	/**
	 * Easing equation function for a bounce (exponentially decaying parabolic bounce) easing in: accelerating from zero velocity.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param a		Amplitude.
	 * @return		The correct value.
	 */
	static float easeInBounce(float t, float a)
	{
	    return 1.0f - easeOutBounce_helper(1.0f-t, 1.0f, a);
	}


	/**
	 * Easing equation function for a bounce (exponentially decaying parabolic bounce) easing in/out: acceleration until halfway, then deceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param a		Amplitude.
	 * @return		The correct value.
	 */
	static float easeInOutBounce(float t, float a)
	{
	    if (t < 0.5) return easeInBounce (2*t, a)/2;
	    else return (t == 1.0) ? 1.0f : easeOutBounce (2*t - 1, a)/2 + 0.5f;
	}

	/**
	 * Easing equation function for a bounce (exponentially decaying parabolic bounce) easing out/in: deceleration until halfway, then acceleration.
	 *
	 * @param t		Current time (in frames or seconds).
	 * @param a		Amplitude.
	 * @return		The correct value.
	 */
	static float easeOutInBounce(float t, float a)
	{
	    if (t < 0.5) return easeOutBounce_helper(t*2, 0.5f, a);
	    return 1.0f - easeOutBounce_helper (2.0f-2*t, 0.5f, a);
	}

	static float qt_sinProgress(float value)
	{
	    return (float)Math.sin((value * M_PI) - M_PI_2) / 2 + 0.5f;
	}

	static float qt_smoothBeginEndMixFactor(float value)
	{
	    return (float)Math.min((float)Math.max(1 - value * 2 + 0.3f, 0.0f), 1.0f);
	}

	// SmoothBegin blends Smooth and Linear Interpolation.
	// Progress 0 - 0.3      : Smooth only
	// Progress 0.3 - ~ 0.5  : Mix of Smooth and Linear
	// Progress ~ 0.5  - 1   : Linear only

	/**
	 * Easing function that starts growing slowly, then increases in speed. At the end of the curve the speed will be constant.
	 */
	static float easeInCurve(float t)
	{
	    float sinProgress = qt_sinProgress(t);
	    float mix = qt_smoothBeginEndMixFactor(t);
	    return sinProgress * mix + t * (1 - mix);
	}

	/**
	 * Easing function that starts growing steadily, then ends slowly. The speed will be constant at the beginning of the curve.
	 */
	static float easeOutCurve(float t)
	{
	    float sinProgress = qt_sinProgress(t);
	    float mix = qt_smoothBeginEndMixFactor(1 - t);
	    return sinProgress * mix + t * (1 - mix);
	}

	/**
	 * Easing function where the value grows sinusoidally. Note that the calculated  end value will be 0 rather than 1.
	 */
	static float easeSineCurve(float t)
	{
	    return ((float)Math.sin(((t * M_PI * 2)) - M_PI_2) + 1) / 2;
	}

	/**
	 * Easing function where the value grows cosinusoidally. Note that the calculated start value will be 0.5 and the end value will be 0.5
	 * contrary to the usual 0 to 1 easing curve.
	 */
	static float easeCosineCurve(float t)
	{
	    return ((float)Math.cos(((t * M_PI * 2)) - M_PI_2) + 1) / 2;
	}


}
