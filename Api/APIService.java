package com.example.step2websoft.olshopgue.Net;


import com.example.step2websoft.olshopgue.Model.request.AddAddress;
import com.example.step2websoft.olshopgue.Model.request.Category;
import com.example.step2websoft.olshopgue.Model.request.ChangePwd;
import com.example.step2websoft.olshopgue.Model.request.DeleteAddress;
import com.example.step2websoft.olshopgue.Model.request.EditProfile;
import com.example.step2websoft.olshopgue.Model.request.Filter;
import com.example.step2websoft.olshopgue.Model.request.ForgetPwd;
import com.example.step2websoft.olshopgue.Model.request.GetAddress;
import com.example.step2websoft.olshopgue.Model.request.Login;
import com.example.step2websoft.olshopgue.Model.request.Otp;
import com.example.step2websoft.olshopgue.Model.request.PlaceOrder;
import com.example.step2websoft.olshopgue.Model.request.ProductAttribute;
import com.example.step2websoft.olshopgue.Model.request.ProductColor;
import com.example.step2websoft.olshopgue.Model.request.ProductId;
import com.example.step2websoft.olshopgue.Model.request.ProductReview;
import com.example.step2websoft.olshopgue.Model.request.SetAddress;
import com.example.step2websoft.olshopgue.Model.request.SetSearch;
import com.example.step2websoft.olshopgue.Model.request.SubmitReview;
import com.example.step2websoft.olshopgue.Model.request.User;
import com.example.step2websoft.olshopgue.Model.request.UserOrder;
import com.example.step2websoft.olshopgue.Model.response.registration.AddReviewResult;
import com.example.step2websoft.olshopgue.Model.response.registration.ChangePwdResult;
import com.example.step2websoft.olshopgue.Model.response.registration.DelAddressResult;
import com.example.step2websoft.olshopgue.Model.response.registration.ForgetPwdResult;
import com.example.step2websoft.olshopgue.Model.response.registration.RegistrationResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.Reviws;
import com.example.step2websoft.olshopgue.Model.response.registration.Slider.SliderResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.address.AddAddressResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.address.DefaultAddressResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.address.GetAddressResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.category.CategoryResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.login.LoginResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.newproduct.NewProductResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.organizer.OrganizerResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.otp.OtpResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.placeOrder.PlaceOrderResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.productAttribute.ProductAttributeResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.productColor.ProductColorResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.productdetail.ProductDetailResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.profile.EditProfileResponse;
import com.example.step2websoft.olshopgue.Model.response.registration.rate.RatingResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {
    //The register call
    @POST("insert_user_register")
    Call<RegistrationResponse> createUser(
            @Body User user);

    @POST("check_reg_otp")
    Call<OtpResponse> registerUser(@Body Otp otp);

    @POST("check_login_api")
    Call<LoginResponse> loginUser(@Body Login user);

    @GET("slider_image")
    Call<SliderResponse> getSlide();

    @POST("sub_cat")
    Call<CategoryResponse> getCategory(@Body Category category);

    @POST("newproduc")
    Call<NewProductResponse> getNewProduct();

    @POST("pro_avg")
    Call<RatingResponse> getRate(@Body ProductId product_id);

    @POST("catproduct")
    Call<OrganizerResponse> getOrganizer(@Body Category category);

    @POST("filter")
    Call<OrganizerResponse> getFilterProductList(@Body Filter category);

    @POST("getproductreview")
    Call<Reviws> getProductReviews(@Body ProductReview review);

    @POST("forgot_password")
    Call<ForgetPwdResult> forgetPassword(@Body ForgetPwd review);

    @POST("forgot_pass")
    Call<ChangePwdResult> changePassword(@Body ChangePwd review);

    @POST("addproductreview")
    Call<AddReviewResult> addProductReviews(@Body SubmitReview review);

    @POST("pro_detail")
    Call<ProductDetailResponse> getDetail(@Body ProductId productId);

    @POST("addressadd")
    Call<AddAddressResponse> postAddress(@Body AddAddress addAddress);

    @POST("getaddress")
    Call<GetAddressResponse> getAddress(@Body GetAddress address);

    @POST("delete_address")
    Call<DelAddressResult> deleteAddress(@Body DeleteAddress address);

    @POST("default_add")
    Call<DefaultAddressResponse> makeDefualtAddress(@Body SetAddress address);

    @POST("search")
    Call<NewProductResponse> getSearch(@Body SetSearch productName);


    @POST("profile_update")
    Call<EditProfileResponse> getEditProfile(@Body EditProfile editProfile);

    @POST("placeorder")
    Call<PlaceOrderResponse> placeOrder(@Body PlaceOrder placeOrder);

    @POST("place_user_order")
    Call<PlaceOrderResponse> placeUserOrder(@Body UserOrder userOrder);

    @POST("get_product_size")
    Call<ProductAttributeResponse> getProductSize(@Body ProductAttribute attribute);

    @POST("get_product_color")
    Call<ProductColorResponse> getProductColor(@Body ProductColor productColor);
}
