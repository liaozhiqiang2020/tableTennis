package com.tt.service.impl;//package com.tt.service.impl;
//
//import com.tt.pojo.DeviceEntity;
//import com.tt.repository.DeviceRepository;
//import com.tt.service.DeviceService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import java.util.*;
//
//
//@Service
//public class DeviceServiceImpl implements DeviceService {
//        @Autowired
//        private DeviceRepository deviceRepository;
//
//        /**
//         * 保存数据
//         * @param device 设备数据
//         * @return
//         */
//        @Override
//        @Transactional
//        public DeviceEntity save(DeviceEntity device) {
//                return deviceRepository.save(device);
//        }
//
//        /**
//         * 根据id查找
//         * @param id  设备id
//         * @return
//         */
//        @Override
//        @Transactional
//        public DeviceEntity findDeviceById(int id) {
//                return deviceRepository.findDeviceById(id);
//        }
//
//        /**
//         * 根据id修改
//         * @param id  设备id
//         * @param device
//         * @return
//         */
//        @Override
//        @Transactional
//        public DeviceEntity updateDeviceById(int id, DeviceEntity device) {
//                return deviceRepository.save(device);
//        }
//
//        @Override
//        public DeviceEntity insertDevice(DeviceEntity device) {
//                return null;
//        }
//
//        /**
//         * 查询所有设备数据
//         * @return
//         */
//        @Override
//        @Transactional
//        public List<DeviceEntity> findAllEntities() {
//                return deviceRepository.findAll();
//        }
//
//
//
//        @Override
//        @Transactional
//        public DeviceEntity updateDevice(DeviceEntity device) {
//                return this.deviceRepository.save(device);
//        }
//
//        @Override
//        public String findAllDeviceByPage(int page, int pageSize) {
//                return null;
//        }
//
//        @Override
//        public String findAllDevice(HttpSession session) {
//                return null;
//        }
//
//
//        @Override
//        @Transactional
//        public void deleteDevice(int deviceId) {
//                DeviceEntity deviceEntity = findDeviceById(deviceId);
////                deviceEntity.setDiscardStatus(0);
//////                this.deviceRepository.save(deviceEntity);
//                this.deviceRepository.delete(deviceEntity);
//        }
//
//
//        /**
//         * 根据椅子sn修改椅子运行状态
//         */
//        @Override
//        public void findChairRuningStatus(String deviceCode,int mcStatus) {
//                Integer deviceId = this.deviceRepository.queryDeviceIdByDeviceCode(deviceCode);
//                DeviceEntity deviceEntity = this.findDeviceById(deviceId);
//                deviceEntity.setMcStatus(mcStatus);
//                this.deviceRepository.save(deviceEntity);
//        }
//
//        /**
//         * 根据椅子sn修改椅子按摩强度
//         */
//        @Override
//        public void findChairStrength(String deviceCode, int strength) {
//                Integer deviceId = this.deviceRepository.queryDeviceIdByDeviceCode(deviceCode);
//                DeviceEntity deviceEntity = this.findDeviceById(deviceId);
//                deviceEntity.setStrength(strength);
//                this.deviceRepository.save(deviceEntity);
//        }
//
//        /**
//         * 根据场地查询所有的设备编码
//         * @param id  场地id
//         */
//        @Override
//        public List<String> getFill_SN(int id) {
//                List<String> deviceEntities = this.deviceRepository.findAllByPlaceId(id);
//                return deviceEntities;
//        }
//
//        /**
//         * 根据权限查询设备
//         * @param id
//         * @return
//         */
//        @Override
//        public List<DeviceEntity> geyDeviceByPid(int id) {
//                return this.deviceRepository.findAllDevice3(id);
//        }
//
//        /**
//         * 根据场地查询设备
//         * @param id
//         * @return
//         */
//        @Override
//        public List<DeviceEntity> getDeviceByplace_id(int id) {
//                return this.deviceRepository.findDevicesByPlaceId(id);
//        }
//
//
//        /**
//         * 无条件查询所有设备
//         * @return
//         */
//
//        @Override
//        public List<DeviceEntity> findDevice2() {
//                return  this.deviceRepository.getAllDevice();
//        }
//
//        @Override
//        public void getAllExcel(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
//
//        }
//
//        @Override
//        public void getExcelModel(HttpServletResponse response) {
//
//        }
//
//
//        @Override
//        public DeviceEntity selectDeviceBYSN(String sn) {
//               return this.deviceRepository.getDeviceBySN(sn);
//        }
//
//        @Override
//        public void getExcelError(Set excelError1, HttpServletResponse response) {
//
//        }
//
//
//        @Override
//        public void updateMcStatusToZero() {
//               List<DeviceEntity> deviceList = this.deviceRepository.findDeviceEntities();//所有按摩椅状态改为待查询
//                for (int i = 0; i <deviceList.size() ; i++) {
//                        DeviceEntity deviceEntity = deviceList.get(i);
//                        deviceEntity.setMcStatus(0);
//                        this.deviceRepository.save(deviceEntity);
//                }
//        }
//}
//
//
//
