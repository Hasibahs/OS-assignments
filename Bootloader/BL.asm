bits 16
org 0x7c00

mov ah, 0x06   
xor al, al      
xor cx, cx      
mov dx, 0x184f  
mov ebx, 0x1f1b   
int 0x10

boot:
    mov si, msg
    mov ah, 0x0e

loop:
    lodsb 
    test al, al
    jz end
    int 0x10                                                
    
    jmp loop ; Repeat

end:
    hlt

msg: 
    db "Bootloader in progress!", 0

times 510 - ($-$$) db 0
dw 0xaa55 

nasm -f bin BL.asm -o BL.bin