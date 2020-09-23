package com.tt.controller;


import com.tt.pojo.DeviceEntity;
import com.tt.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class DeviceController {
    //注入
    @Autowired
    private DeviceService deviceService;

    /**
     * 全部查询
     * @return 返回所有设备内容
     */
    @GetMapping(value = "/deviceMgr/allDevice")
    public @ResponseBody
    List<DeviceEntity> getAll() {
        return this.deviceService.findAllEntities();
    }
    /**
     * 根据设备id查询单个设备内容
     * @param id 设备Id
     * @return 单个设备内容
     */
    @RequestMapping(value = "/deviceMgr/device",method=RequestMethod.GET)
    public @ResponseBody
    DeviceEntity getDeviceById(@PathParam("id") int id ) {
            return this.deviceService.findDeviceById(id);
    }



    /**
     * 跳转到设备库存管理页面
     * @return  转发到设备库存管理页面
     * @auther liaozhiqiang
     * @date 2018/7/11
     */
    @GetMapping(value="/deviceMgr/turnToInventoryMgr")
    public ModelAndView turnToInventoryMgr(){
        return new ModelAndView("./baseInfo/inventoryMgr");
    }

    /**
     * 跳转到设备控制页面
     * @return 设备控制view
     * @auther liaozhiqiang
     * @date 2018/7/11
     */
    @GetMapping(value="/deviceMgr/turnToDeviceCtrl")
    public ModelAndView turnToDeviceCtrl(){
        this.deviceService.updateMcStatusToZero();
        return new ModelAndView("./deviceManager/deviceCtrlMgr");
    }


    /**
     * 跳转到设备场地绑定页面
     * @return 设备场地绑定页面
     * @auther liaozhiqiang
     * @date 2018/7/11
     */
    @GetMapping(value="/deviceMgr/turnToDeviceMgr")
    public ModelAndView turnToDeviceMgr(){
        return new ModelAndView("./baseInfo/deviceMgr");
    }



    /**
     * 全部查询
     * @return 返回所有设备内容
     */
    @GetMapping(value = "/deviceMgr/getAllDevice")
    public @ResponseBody
    String getAllDevice(HttpSession session) {
        return this.deviceService.findAllDevice(session);
    }



    /**
     * 插入一条设备数据
     * @param deviceEntity 插入的设备信息
     * @return 设备信息
     */
    @RequestMapping(value = "/deviceMgr/insertDevice",method = RequestMethod.POST)
    public @ResponseBody
    DeviceEntity insertDevice(@RequestBody DeviceEntity deviceEntity){
        deviceEntity.setMcIsNotOnline(0);
        return  this.deviceService.insertDevice(deviceEntity);
    }

    /**
     * 更改设备数据
     * @param deviceEntity 更改的设备信息
     * @return 设备信息
     */
    @RequestMapping(value = "/deviceMgr/updateDevice",method = RequestMethod.POST)
    public @ResponseBody
    DeviceEntity updateDevice(@RequestBody DeviceEntity deviceEntity){
        return this.deviceService.updateDevice(deviceEntity);

    }

    /**
     * 逻辑删除设备数据
     * @param map  设备修改数据
     */
    @RequestMapping(value = "/deviceMgr/deleteDevice",method = RequestMethod.POST)
    public @ResponseBody
    void deleteDevice(@RequestBody Map<String,Object> map){
        this.deviceService.deleteDevice(Integer.parseInt(map.get("id").toString()));
    }


    /**
     * 响应导入结果
     * @param result 结果内容
     * @param response 响应
     */
   @GetMapping(value = "/deviceMgr/getExcelError")
   public void getExcelError(@RequestParam("result") Set result,HttpServletResponse response){
       this.deviceService.getExcelError(result,response);
   }





























    /**                                                                         失效代码
     *
     * 更改分公司名称
     * @param id 分公司id  , newName 新名字
     * @return BranchEntity
    @RequestMapping(value = "/branch/updateBranchName",method=RequestMethod.POST)
    public @ResponseBody BranchEntity updateBranchNameById(@PathParam("id")int id ,@RequestBody String newName) {
        BranchEntity result = new BranchEntity();
            result = branchService.updateBranchNameById(id,newName);
        return result;
    }
    /**
     * 更改分公司地址
     * @param id 分公司id , newAddress 新办公地址
     * @return BranchEntity
    @RequestMapping(value = "/branch/updateBranchAddress",method=RequestMethod.POST)
    public @ResponseBody
    BranchEntity updateBranchAddressById(@PathParam("id")int id ,@RequestBody String newAddress) {
        BranchEntity result = new BranchEntity();
        result = branchService.updateBranchAddressById(id,newAddress);
        return result;
    }
    /**
     * 更改分公司负责人
     * @param id 分公司id , newPrincipal 新分公司负责人
     * @return BranchEntity
    @RequestMapping(value = "/branch/updateBranchPrincipal",method=RequestMethod.POST)
    public @ResponseBody
    BranchEntity updateBranchPrincipalById(@PathParam("id")int id ,@RequestBody String newPrincipal) {
        BranchEntity result = new BranchEntity();
        result = branchService.updateBranchPrincipalById(id,newPrincipal);
        return result;
    }
    /**
     * 更改分公司联系电话
     * @param id 分公司id , newTelephone新分公司联系电话
     * @return BranchEntity
    @RequestMapping(value = "/branch/updateBranchTelephone",method=RequestMethod.POST)
    public @ResponseBody
    BranchEntity updateBranchTelephoneById(@PathParam("id")int id ,@RequestBody String newTelephone) {
        BranchEntity result = new BranchEntity();
        result = branchService.updateBranchTelephoneById(id,newTelephone);
        return result;
    }
    /**
     * 更改分公司联系邮箱
     * @param id 分公司id , newEmail新分公司联系邮箱
     * @return BranchEntity
    @RequestMapping(value = "/branch/updateBranchEmail",method=RequestMethod.POST)
    public @ResponseBody
    BranchEntity updateBranchEmailById(@PathParam("id")int id ,@RequestBody String newEmail) {
        BranchEntity result = new BranchEntity();
        result = branchService.updateBranchEmailById(id,newEmail);
        return result;
    }
    /**
     * 更该分公司事物状态
     * @param id 分公司id
     * @param newDeleteID delete_id
     * @return RequestBody
    @RequestMapping(value = "/branch/updateBranchAffair",method =RequestMethod.POST)
    public @ResponseBody
    BranchEntity updateBranchAffairById(@PathParam("id") int id,@RequestBody int newDeleteID){
        BranchEntity result = new BranchEntity();
        result = branchService.updateBranchAffairById(id,newDeleteID);
        return result;
    }
    */
    /**
     * 导出全部查询
     * @return 返回所有设备内容
     */
    @GetMapping(value = "/deviceMgr/getallDevice")
    public
    void getAllExcel(HttpServletRequest request,HttpServletResponse response,HttpSession session) {

     this.deviceService.getAllExcel(request,response,session);
    }


    /**
     * 导出模板
     * @param response
     */


    @GetMapping(value = "/deviceMgr/getmodel")
    public
    void getmodelExcel(HttpServletResponse response) {

        this.deviceService.getExcelModel(response);
    }


}
