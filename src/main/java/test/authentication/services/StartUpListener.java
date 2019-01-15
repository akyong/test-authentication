/**
 * Copyright (c) 2019. PT. Distributor Indonesia Unggul. All rights reserverd.
 *
 * This source code is an unpublished work and the use of  a copyright  notice
 * does not imply otherwise. This source  code  contains  confidential,  trade
 * secret material of PT. Distributor Indonesia Unggul.
 * Any attempt or participation in deciphering, decoding, reverse  engineering
 * or in any way altering the source code is strictly  prohibited, unless  the
 * prior  written consent of Distributor Indonesia Unggul. is obtained.
 *
 * Unless  required  by  applicable  law  or  agreed  to  in writing, software
 * distributed under the License is distributed on an "AS IS"  BASIS,  WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or  implied.  See  the
 * License for the specific  language  governing  permissions  and limitations
 * under the License.
 *
 * Author : Bobby
 */


package test.authentication.services;

import test.authentication.domain.configuration.ApplicationConfiguration;
import test.authentication.domain.security.Role;
import test.authentication.domain.security.User;
import test.authentication.domain.security.UserRole;
import test.authentication.services.security.BCryptPasswordEncoderService;
import test.authentication.services.security.RoleService;
import test.authentication.services.security.UserRoleService;
import test.authentication.services.security.UserService;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Singleton
public class StartUpListener {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static UserService userService;
    private static RoleService roleService;
    private static UserRoleService userRoleService;
    private static BCryptPasswordEncoderService bCryptPasswordEncoderService;
    private static ApplicationConfiguration applicationConfiguration;

    public StartUpListener(UserService userService, RoleService roleService, UserRoleService userRoleService, ApplicationConfiguration applicationConfiguration, BCryptPasswordEncoderService bCryptPasswordEncoderService) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
        this.applicationConfiguration = applicationConfiguration;
        this.bCryptPasswordEncoderService = bCryptPasswordEncoderService;
    }

    public void CheckUserToInsert() {
        try {
            User user = userService.findByEmail("bobby@tokodistributor.com");
            String password = bCryptPasswordEncoderService.encode(applicationConfiguration.getDefaultPassword());
            if (user == null) {
                userService.save("bobby@tokodistributor.com", "bobby",password, true, false, false, false);
                logger.info("\n---------------CREATE USER-----------------\n---------------EMAIL: bobby@tokodistributor.com-----------------\n---------------PASSWORD: <PROTECTED>-----------------\n---------------USER CREATED-----------------\n");
            } else {
                logger.info("\n---------------SOME USER ALREADY EXIST-----------------");
            }
        } catch (Exception ex) {
            logger.info("\nError <INSERT USER> : " +ex);
        }
    }

    public void CheckRoleToInsert(){
        try{
            Role roleAdmin      = roleService.findByAuthority("ROLE_ADMIN");
            Role roleCorpAdmin  = roleService.findByAuthority("ROLE_CORP_ADMIN");
            Role roleBuyer      = roleService.findByAuthority("ROLE_BUYER");
            Role roleSeller     = roleService.findByAuthority("ROLE_SELLER");

            if(roleAdmin == null){
                roleService.save("Admin Role","ROLE_ADMIN","Y");
                logger.info("\n---------------CREATE ROLE-----------------\n---------------NAME: Admin Role-----------------\n---------------AUTHORITY: ROLE_ADMIN-----------------\n---------------ROLE CREATED-----------------\n");
            }
            else{
                logger.info("\n---------------ROLE ADMIN ALREADY EXIST-----------------");
            }
            if(roleCorpAdmin == null){
                roleService.save("Corp Admin Role","ROLE_CORP_ADMIN","Y");
                logger.info("\n---------------CREATE ROLE-----------------\n---------------NAME: Corp Admin Role-----------------\n---------------AUTHORITY: ROLE_CORP_ADMIN-----------------\n---------------ROLE CREATED-----------------\n");
            }
            else{
                logger.info("\n---------------ROLE CORP ADMIN ALREADY EXIST-----------------");
            }
            if(roleBuyer == null){
                roleService.save("Buyer Role","ROLE_BUYER","Y");
                logger.info("\n---------------CREATE ROLE-----------------\n---------------NAME: Buyer Role-----------------\n---------------AUTHORITY: ROLE_BUYER-----------------\n---------------ROLE CREATED-----------------\n");
            }
            else{
                logger.info("\n---------------ROLE BUYER ALREADY EXIST-----------------");
            }
            if(roleSeller == null){
                roleService.save("Seller Role","ROLE_SELLER","Y");
                logger.info("\n---------------CREATE ROLE-----------------\n---------------NAME: Seller Role-----------------\n---------------AUTHORITY: ROLE_SELLER-----------------\n---------------ROLE CREATED-----------------\n");
            }
            else{
                logger.info("\n---------------ROLE SELLER ALREADY EXIST-----------------");
            }
        }
        catch (Exception ex){
            logger.info("\nError <INSERT ROLE> : " +ex);
        }
    }

    public void CheckUserRoleToInsert(){
        try{
            User user           = userService.findByEmail("bobby@tokodistributor.com");
            Role roleAdmin      = roleService.findByAuthority("ROLE_ADMIN");
            UserRole userRole   = userRoleService.findByUserAndRole(user,roleAdmin);


            if(userRole == null){
                userRoleService.save(user,roleAdmin);
                logger.info("\n---------------CREATE USER ROLE-----------------\n---------------USER: "+user.getEmail()+"-----------------\n---------------ROLE: "+roleAdmin.getAuthority()+"-----------------\n---------------USER ROLE CREATED-----------------\n");
            }
            else{
                logger.info("\n---------------USER ROLE ALREADY EXIST-----------------");
            }
        }
        catch (Exception ex)
        {
            logger.info("\nError <INSERT USER ROLE> : " +ex);
        }
    }
}