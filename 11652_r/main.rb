hash = Hash.new
hash.default = 0

size = Integer(gets)

size.times do
  number = gets.strip

  hash["#{number}"] = hash["#{number}"]+1
end

max = hash.max_by(2){ |key, value| value }
min = hash.min_by{ |key, value| key}

puts "#{max}"
puts "#{min}"