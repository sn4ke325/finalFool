push 0
push 5
push 3
add
push function0
push -3
lfp
add
lw
push -3
lfp
add
push 1
beq label2
push 10
b label3
label2:
push 0
label3:
print
halt

function0:
cfp
lra
push 2
lfp
add
lw
push -2
lfp
add
lw
push -2
lfp
lw
add
lw
beq label0
push 0
b label1
label0:
push 1
label1:
srv
pop
sra
pop
pop
pop
sfp
lrv
lra
js
