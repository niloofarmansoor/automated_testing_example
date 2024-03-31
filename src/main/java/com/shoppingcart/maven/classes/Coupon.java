package com.shoppingcart.maven.classes;

public class Coupon {

        private String couponCode;

        public Coupon(String couponCode) {
            this.couponCode = couponCode;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public static boolean isValidCoupon(String couponCode){

            if (couponCode == "Save10" ||
                couponCode == "Save30" ||
                couponCode == "Save50" ||
                couponCode == "Free")
                return true;

            return false;
            }

        public double applyCoupon(double cartTotal, String couponCode){

            if (isValidCoupon(couponCode)) {
                if (couponCode == "Save10"){
                    return cartTotal * 0.9;
                } 
                else if (couponCode == "Save30"){
                    return cartTotal * 0.7;
                }
                else if (couponCode == "Save50"){
                    return cartTotal * 0.5;
                }
                else{
                    return 0; //free couponCode == "Free"
                }
            }
            else
                return cartTotal;

        }


}
