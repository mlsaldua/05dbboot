sap.ui.define([
   "sap/ui/core/mvc/Controller",
   "jquery.sap.global",
   "capm/util/service",
   "sap/m/MessageBox"
], function (Controller, jQuery, service, MessageBox) {
   "use strict";
   return Controller.extend("capm.controller.Main", {
   
   		onInit: function(){
   			var oModel = new sap.ui.model.json.JSONModel();
   			this.getView().setModel(oModel, "vendorModel");
   			oModel.setData({
   				"postPayload" : {
   				    "companyName": "",
				    "firstName": "",
				    "lastName": "",
				    "website": "",
				    "email": "",
				    "status": "A",
				    "regDate": "",
   				},
   				"vendor" : {}
   			});
   		},
   		
   		onSave: function(){
   			var oModel = this.getView().getModel("vendorModel");
   			var oPayload = oModel.getProperty("/postPayload");
   			service.callService("/vendor", "POST", oPayload).then(function(data){
				MessageBox.confirm("Saved Success");
   			}.bind(this)).catch(function(oError){
   				MessageBox.error(oError);
   			})
   		},
   		
   		onLoadData: function(){
   			service.callService("/newVendor", "GET", {}).then(function(data){
   					var oTable = this.getView().byId("idTable");
   					var oModel = this.getView().getModel("vendorModel");
   					oModel.setProperty("/vendor", data._embedded.vendor);
   					console.log(oModel.getData());
   					console.log(data);
   			}.bind(this)).catch(function(oError){
   			
   			})
   		}
   });
});