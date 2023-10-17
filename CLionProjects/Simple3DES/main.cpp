#include <openssl/evp.h>
#include <openssl/des.h>
#include <stdio.h>
#include <string.h>
#include<iostream>
using namespace std;

int main() {
    // 简单3DES加密
    unsigned char input_data[] = "Hello, World!";  // 输入数据
    int data_len = strlen((const char*)input_data);
    int padded_len = (data_len % 8 == 0) ? data_len : data_len + (8 - data_len % 8);
    unsigned char padded_data[padded_len];
    memset(padded_data, 8 - data_len % 8, padded_len);  // 使用简单的填充
    memcpy(padded_data, input_data, data_len);

    unsigned char encrypted_data[128];  // 加密后的数据
    unsigned char decrypted_data[128];  // 解密后的数据
    static DES_cblock key1 = {0x01,0x02,0x03,0x04,0x05,0x06,0x07,0x08};  // 密钥1
    static DES_cblock key2 = {0x09,0x0A,0x0B,0x0C,0x0D,0x0E,0x0F,0x10};  // 密钥2
    static DES_cblock key3 = {0x11,0x12,0x13,0x14,0x15,0x16,0x17,0x18};  // 密钥3
    DES_key_schedule schedule1, schedule2, schedule3;  // 密钥计划

    // 设置密钥计划
    DES_set_key_unchecked(&key1, &schedule1);
    DES_set_key_unchecked(&key2, &schedule2);
    DES_set_key_unchecked(&key3, &schedule3);

    // 加密
    for (int i = 0; i < padded_len; i += 8) {
        DES_ecb3_encrypt((DES_cblock*)(padded_data + i), (DES_cblock*)(encrypted_data + i),
                         &schedule1, &schedule2, &schedule3, DES_ENCRYPT);
    }

    // 解密
    for (int i = 0; i < padded_len; i += 8) {
        DES_ecb3_encrypt((DES_cblock*)(encrypted_data + i), (DES_cblock*)(decrypted_data + i),
                         &schedule1, &schedule2, &schedule3, DES_DECRYPT);
    }

    // 获取填充长度
    int padding_length = decrypted_data[padded_len - 1];
    // 设置终止字符
    decrypted_data[padded_len - padding_length] = '\0';

    // 输出结果
    cout << "Original: " << input_data << endl;
    cout<<"Encrypted:";
    for(int i = 0; i < padded_len; ++i) {
        printf("%02x", encrypted_data[i]);
    }
    cout << endl;
    cout << "Decrypted: " << decrypted_data << endl;

    return 0;
}
